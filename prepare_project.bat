@echo off
setlocal EnableDelayedExpansion

echo [1/7] Beende laufende Prozesse...
taskkill /F /IM java.exe /T 2>NUL
timeout /t 2 /nobreak >NUL

echo [2/7] Säubere alte Offline-Abhängigkeiten...
if exist "offline_dependencies" (
    rd /s /q "offline_dependencies"
)
mkdir offline_dependencies

echo [3/7] Initialisiere Projekt...
call gradlew.bat clean --no-daemon
if errorlevel 1 (
    echo [FEHLER] Gradle Clean fehlgeschlagen
    pause
    exit /b 1
)

echo [4/7] Lade Abhängigkeiten...
call gradlew.bat --no-daemon --refresh-dependencies build
if errorlevel 1 (
    echo [FEHLER] Build fehlgeschlagen
    pause
    exit /b 1
)

echo [5/7] Kopiere Minecraft-Assets...
set "ASSET_DIRS=0"
if exist "%APPDATA%\.minecraft\assets" (
    robocopy "%APPDATA%\.minecraft\assets" "offline_dependencies\assets" /E /NFL /NDL /NJH /NJS /nc /ns /np
    set /a "ASSET_DIRS+=1"
)

if exist "%USERPROFILE%\.gradle\caches\fabric-loom" (
    robocopy "%USERPROFILE%\.gradle\caches\fabric-loom" "offline_dependencies\fabric-loom" /E /NFL /NDL /NJH /NJS /nc /ns /np
    set /a "ASSET_DIRS+=1"
)

if exist "%USERPROFILE%\.gradle\caches\minecraft" (
    robocopy "%USERPROFILE%\.gradle\caches\minecraft" "offline_dependencies\minecraft" /E /NFL /NDL /NJH /NJS /nc /ns /np
    set /a "ASSET_DIRS+=1"
)

echo [6/7] Kopiere Gradle-Cache...
if exist "%USERPROFILE%\.gradle\caches\modules-2" (
    robocopy "%USERPROFILE%\.gradle\caches\modules-2" "offline_dependencies\gradle-modules" /E /NFL /NDL /NJH /NJS /nc /ns /np /XF modules-2.lock /XD metadata-2.96
    set /a "ASSET_DIRS+=1"
)

echo.
echo [INFO] Prüfe build.gradle...
if not exist "build.gradle" (
    echo [FEHLER] build.gradle nicht gefunden!
    pause
    exit /b 1
)

echo.
echo [INFO] Zusammenfassung:
echo [INFO] %ASSET_DIRS% Verzeichnisse kopiert
echo [INFO] Verzeichnisstruktur:
dir offline_dependencies

if %ASSET_DIRS% LSS 4 (
    echo.
    echo [WARNUNG] Einige Verzeichnisse fehlen!
    echo [WARNUNG] Erwartete 4 Verzeichnisse, aber nur %ASSET_DIRS% gefunden.
)

echo.
echo [INFO] Teste Offline-Build...
call gradlew.bat build --offline
if errorlevel 1 (
    echo [WARNUNG] Offline-Build fehlgeschlagen
) else (
    echo [INFO] Offline-Build erfolgreich!
)

echo.
echo [INFO] Setup abgeschlossen!
echo [INFO] Drücken Sie eine Taste zum Beenden...
pause >NUL
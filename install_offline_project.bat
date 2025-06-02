@echo off
setlocal EnableDelayedExpansion

REM Java-Version prüfen
echo [1/5] Java-Version prüfen ...
java -version 2>nul
IF ERRORLEVEL 1 (
    echo [FEHLER] Java ist nicht installiert oder nicht in PATH!
    pause
    exit /b 1
)

REM Zielverzeichnis prüfen
echo [2/5] Zielverzeichnis prüfen ...
set "USER_GRADLE_DIR=%USERPROFILE%\.gradle"
IF EXIST "%USER_GRADLE_DIR%" (
    echo [INFO] Erstelle Backup von bestehendem .gradle-Verzeichnis...
    taskkill /F /IM java.exe >nul 2>&1
    timeout /t 2 /nobreak >nul
    ren "%USER_GRADLE_DIR%" ".gradle_backup_%date:~-4,4%%date:~-7,2%%date:~-10,2%"
    IF ERRORLEVEL 1 (
        echo [FEHLER] Backup fehlgeschlagen! Versuche alternative Methode...
        robocopy "%USER_GRADLE_DIR%" "%USER_GRADLE_DIR%_backup_%date:~-4,4%%date:~-7,2%%date:~-10,2%" /E /MOVE
        IF ERRORLEVEL 8 (
            echo [FEHLER] Auch alternative Backup-Methode fehlgeschlagen!
            pause
            exit /b 1
        )
    )
)

REM Lokalen .gradle-Ordner prüfen
echo [3/5] Prüfe lokalen .gradle-Ordner...
IF NOT EXIST ".gradle" (
    echo [FEHLER] Lokaler .gradle-Ordner nicht gefunden!
    pause
    exit /b 1
)

REM Kopieren mit Fortschrittsanzeige
echo [4/5] Kopiere .gradle nach "%USER_GRADLE_DIR%" ...
mkdir "%USER_GRADLE_DIR%" 2>nul
IF ERRORLEVEL 1 (
    echo [WARNUNG] Konnte Verzeichnis nicht erstellen - möglicherweise bereits vorhanden
)
xcopy ".gradle" "%USER_GRADLE_DIR%" /E /I /Y /Q /R /Z

REM Gradle Build
echo [5/5] Starte Offline-Build ...
IF NOT EXIST "gradlew.bat" (
    echo [FEHLER] gradlew.bat nicht gefunden!
    pause
    exit /b 1
)
echo [INFO] Überprüfe JAVA_HOME...
if "%JAVA_HOME%" == "" (
    echo [WARNUNG] JAVA_HOME ist nicht gesetzt!
)
echo [INFO] Verwende Java in: %JAVA_HOME%
call gradlew.bat build --offline --stacktrace --info


echo Fertig! Projekt ist nun bereit für die Offline-Nutzung.
pause
exit /b 0
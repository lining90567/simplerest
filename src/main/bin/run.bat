@REM app launcher script
@REM
@REM Environment:
@REM JAVA_HOME - location of a JDK home dir (optional if java on path)
@setlocal enabledelayedexpansion

@echo off

cd %~dp0
cd ../

if "%JAVA_OPS%" == "" set JAVA_OPS=-Dfile.encoding=utf-8 -server -Xmx32m -Xms32m -Xss256k
java %JAVA_OPS% -jar %cd%\lib\simplerest-1.0.0.jar -f %cd%\conf\simplerest.properties
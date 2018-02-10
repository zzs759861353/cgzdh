title auth_wssb_install
echo ::======================
echo ::以后台方式构建打包为jar
echo ::======================
set JAVA_HOME=D:\SIDevTools-3.7\jdk\jdk1.8.0_25
set CLASSPATH=.;%JAVA_HOME%\lib\tools.jar
set Path=D:\SIDevTools-3.7\maven\apache-maven-3.1.1\bin;%JAVA_HOME%\bin;%Path%

echo [INFO] build and install modules.
call mvn --settings D:\SIDevTools-3.7\maven\apache-maven-3.1.1\conf\settings.xml clean install  -Dmaven.test.skip=true -X  -e -U
pause
#!/bin/sh

###  ------------------------------- ###
###  simplerest launcher script      ###
###  ------------------------------- ###

cd `dirname $0`
cd ../
if [ -z "$JAVA_OPS" ]; then
  JAVA_OPS="-Dfile.encoding=utf-8 -Xms32M -Xmx32M -Xss256K"
fi
java $JAVA_OPS -jar  $(pwd)/lib/simplerest-1.0.0.jar -f $(pwd)/conf/simplerest.properties
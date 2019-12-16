# set -x

function create_JAVA_LIB {
    JAVA_LIB_BASE="/cygdrive/d/00-software/kotlin/kotlinc/lib"
    JAVA_LIB=""
    for i in $(find $JAVA_LIB_BASE -iname "*.jar"); do
        JAVA_LIB=$(cygpath -w $i)";$JAVA_LIB"
    done
    export JAVA_LIB
    echo "java libs set";
}

[ -e $JAVA_LIB ] && create_JAVA_LIB

rm -rf tut1 META-INF
kotlinc-jvm main.kt
java -cp $JAVA_LIB tut1/MainKt


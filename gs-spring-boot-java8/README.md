# 查看存活的类
jmap -histo:live pid | more
由于没有发生OOM，所有在内存使用率较高的时候自己手动dump
jmap -dump:format=b,file=文件名 [pid]
dump文件比较大，如果要下载下来可以先 压缩
tar -czvf dump.hprof.zip dump.hprof
hprof文件没有问题的话，使用MAT打开的时候总是抛出 Java Heap Error. 可能是默认的1024m内存不够用了
机器配置是参数：
JVM_HEAP="-XX:NewSize=2048m -XX:MaxNewSize=2048m -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError -XX:ReservedCodeCacheSize=128m -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m
-XX:InitialCodeCacheSize=128m -XX:NativeMemoryTracking=summary"
JVM_SIZE="-Xmx5g -Xms5g -Xss512k"

# 漏洞报告

## 报错信息

```
java.lang.ArrayIndexOutOfBoundsException: 65536
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.hbCreateDecodeTables(BZip2CompressorInputStream.java:422)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.createHuffmanDecodingTables(BZip2CompressorInputStream.java:546)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.recvDecodingTables(BZip2CompressorInputStream.java:518)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.getAndMoveToFrontDecode(BZip2CompressorInputStream.java:555)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.initBlock(BZip2CompressorInputStream.java:324)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.<init>(BZip2CompressorInputStream.java:135)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.<init>(BZip2CompressorInputStream.java:112)
```

```
java.lang.ArrayIndexOutOfBoundsException: 6
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.recvDecodingTables(BZip2CompressorInputStream.java:493)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.getAndMoveToFrontDecode(BZip2CompressorInputStream.java:555)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.initBlock(BZip2CompressorInputStream.java:324)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.<init>(BZip2CompressorInputStream.java:135)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.<init>(BZip2CompressorInputStream.java:112)
```

```
java.lang.ArrayIndexOutOfBoundsException: 18002
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.getAndMoveToFrontDecode(BZip2CompressorInputStream.java:605)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.initBlock(BZip2CompressorInputStream.java:324)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.<init>(BZip2CompressorInputStream.java:135)
	at org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream.<init>(BZip2CompressorInputStream.java:112)
```

## 漏洞概述

漏洞类型： bug

在解析格式错误的文件 `BZip2CompressorInputStream.<init>` 时遇到多个未经检查的异常。

`ArrayIndexOutOfBoundsException` 是此 API 中未记录的未经检查的异常;因此，此类异常可能会导致应用程序中出现意外的稳定性问题。相反，应抛出一个 `IOException` 指示输入流包含格式错误的数据。

三个不同（但可能相关）的异常源的堆栈跟踪如上所示

### 影响版本

Commons Compress 1.14 1.15

修复版本：1.16
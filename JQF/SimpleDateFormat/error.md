## 漏洞报告

### 报错信息

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 38
at java.base/java.text.SimpleDateFormat.subFormat(SimpleDateFormat.java:1124)
at java.base/java.text.SimpleDateFormat.format(SimpleDateFormat.java:985)
at java.base/java.text.SimpleDateFormat.format(SimpleDateFormat.java:955)
at java.base/java.text.DateFormat.format(DateFormat.java:367)
at DateFormatterTest.main(DateFormatterTest.java:16)
```

### 漏洞概述

SimpleDateFormat#format（Date） 通过包含 256 个或更多非 ASCII Unicode 字符序列的格式字符串设置日期格式时，会引发 OOB 异常。

发生这种情况的原因是 SimpleDateFormat#compile（String pattern） 使用带有标记数据和 1 或 2 字节长度字段的打包表示形式编译输入格式字符串。但是，在存在非 ASCII unicode 字符序列（即每个字符值大于 128）的特定情况下，编译器仅使用短的 1 字节长度字段。因此，如果一行中有超过 256 个 unicode 字符，则长度字段会溢出并导致计数损坏。

损坏的计数会导致在使用此编译模式格式化日期时引发 OOB 异常。

### 影响版本

core-libs 9.0.1~10

修复版本

core-libs 12


## 漏洞报告

### 报错信息

```
org.apache.tika.exception.TikaException: Unexpected RuntimeException from org.apache.tika.parser.pdf.PDFParser@1fbfd6<mailto:org.apache.tika.parser.pdf.PDFParser@1fbfd6>
      at org.apache.tika.parser.CompositeParser.parse(CompositeParser.java:244)
      at org.apache.tika.parser.CompositeParser.parse(CompositeParser.java:242)
      at org.apache.tika.parser.AutoDetectParser.parse(AutoDetectParser.java:120)
      at com.pc.TikaWithIndexing.main(TikaWithIndexing.java:53)
Caused by: java.lang.ClassCastException: org.apache.pdfbox.cos.COSString cannot be cast to org.apache.pdfbox.cos.COSDictionary
      at org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink.getAction(PDAnnotationLink.java:93)
      at org.apache.tika.parser.pdf.PDF2XHTML.endPage(PDF2XHTML.java:148)
      at org.apache.pdfbox.util.PDFTextStripper.processPage(PDFTextStripper.java:444)
      at org.apache.pdfbox.util.PDFTextStripper.processPages(PDFTextStripper.java:366)
      at org.apache.pdfbox.util.PDFTextStripper.writeText(PDFTextStripper.java:322)
      at org.apache.tika.parser.pdf.PDF2XHTML.process(PDF2XHTML.java:66)
      at org.apache.tika.parser.pdf.PDFParser.parse(PDFParser.java:153)
      at org.apache.tika.parser.CompositeParser.parse(CompositeParser.java:242)
      ... 3 more
```

### 漏洞概述

问题出在 `org.apache.tika.parser.pdf.PDFParser` 解析 PDF 文件时遇到了一个 `ClassCastException`。具体来说，`org.apache.pdfbox.cos.COSString` 不能被强制转换为 `org.apache.pdfbox.cos.COSDictionary`。这个错误通常是由于 PDF 文件中的某些结构不符合预期格式导致的。



### 可能的影响

1. **服务中断**： 如果异常未被捕获和处理，可能会导致应用程序崩溃或服务中断，影响用户体验和服务可用性。
2. **信息泄露**： 如果异常信息被直接暴露给用户，可能会泄露内部实现细节，增加攻击者利用其他漏洞的风险。
3. **拒绝服务（DoS）攻击**： 攻击者可能会利用这个异常，通过提交特制的 PDF 文件导致应用程序频繁崩溃，从而实现拒绝服务攻击。

### 影响版本

Apache Tika 1.2 to 1.18

修复版本 

Apache Tika 1.19 或者更高版本。
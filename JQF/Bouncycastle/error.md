# 漏洞报告

## 漏洞信息

![image-20240713165110226](./image-20240713165110226.png)

## 漏洞概述

Bouncy Castle Crypto（又名 BC Java）1.63 中的 ASN.1 解析器可以通过构建的 ASN.1 数据触发大量尝试的内存分配，并导致 OutOfMemoryError 错误。

该异常显示我们出现内存不足错误。我们能够用很短的asn.1触发我们能分配的java进程内的可用的所有内存，从而导致java崩溃
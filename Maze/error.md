# 漏洞报告
***

## 漏洞概述
* 漏洞类型: 程序异常（MazeFuzzer$TreasureFoundException）

* 漏洞描述: 在使用Jazzer工具测试MazeFuzzer库时，发现了一个异常MazeFuzzer$TreasureFoundException。该异常表明在处理迷宫输入时，程序找到了宝藏并抛出了异常。
## jazzer 报错截图
![img.png](img.png)
## 详细信息
#### 异常信息:
```
== Java Exception: MazeFuzzer$TreasureFoundException:
..███████████████████
 .  █ █ █   █ █...  █
█.█ █ █ ███ █ █.█.███
█.█ █   █      .█.  █
█.█████ ███ ███.█.███
█.....  █   █ █.█...█
█.███.███████ █.███.█
█.█.....█ █.....█...█
███████.█ █.█████.███
█   █.......█.....█ █
█ ███████ █.███.███ █
█   █     █.█ █...█ █
███ ███ █ ███ █.███ █
█     █ █ █   █...  █
█ ███████ █ █ █.█.█ █
█ █         █ █ █.█ █
█ █ █████████ ███.███
█   █   █   █ █ █...█
█ █ █ ███ █████ ███.█
█ █         █........
███████████████████.#

        at MazeFuzzer.lambda$fuzzerTestOneInput$0(MazeFuzzer.java:62)
        at MazeFuzzer.executeCommands(MazeFuzzer.java:121)
        at MazeFuzzer.fuzzerTestOneInput(MazeFuzzer.java:58)
DEDUP_TOKEN: 16823e6fada87f75
== libFuzzer crashing input ==
MS: 2 CopyPart-Custom-; base unit: 96dedc5d0faab1e51d320d923d52b718e31baccd
artifact_prefix='./'; Test unit written to ./crash-3dce3f4278389205653e6b5539e71d4c0de5edfe
reproducer_path='.'; Java reproducer written to .\Crash_3dce3f4278389205653e6b5539e71d4c0de5edfe.java
```


#### 异常分析:

* 异常描述: MazeFuzzer$TreasureFoundException 表示在处理迷宫输入时，程序找到了宝藏并抛出了异常。
* 异常发生位置: MazeFuzzer.lambda$fuzzerTestOneInput$0 方法中，该方法负责处理迷宫输入并执行相关命令。
#### 调用栈:
```
at MazeFuzzer.lambda$fuzzerTestOneInput$0(MazeFuzzer.java:62)
at MazeFuzzer.executeCommands(MazeFuzzer.java:121)
at MazeFuzzer.fuzzerTestOneInput(MazeFuzzer.java:58)
```

## 影响范围
#### 受影响版本: JDK 1.8

#### 潜在影响:

* 程序崩溃: 程序在找到宝藏时抛出异常，导致程序崩溃。
* 功能中断: 如果异常发生在关键功能过程中，可能导致功能中断或无法继续执行。
## 复现步骤
* 使用Jazzer工具对MazeFuzzer库进行模糊测试。
* 提供包含迷宫数据的输入，触发MazeFuzzer的处理过程。
* 观察程序抛出 MazeFuzzer$TreasureFoundException 异常。
## 修复建议
* 异常处理: 在处理迷宫数据过程中捕获并处理 MazeFuzzer$TreasureFoundException 异常，避免程序崩溃。
* 逻辑调整: 调整程序逻辑，确保在找到宝藏时不会抛出异常，而是正常处理该情况。
* 输入验证: 增加输入数据的验证逻辑，确保数据格式合法，减少异常发生的可能性。
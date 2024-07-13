# 漏洞报告

## 报错信息

```
org.apache.maven.InternalErrorException: Internal error: java.lang.NullPointerException
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:122)
	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:993)
	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:345)
	at org.apache.maven.cli.MavenCli.main(MavenCli.java:191)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
Caused by: java.lang.NullPointerException
	at org.codehaus.plexus.util.xml.pull.MXParser.fillBuf(MXParser.java:3054)
	at org.codehaus.plexus.util.xml.pull.MXParser.more(MXParser.java:3080)
	at org.codehaus.plexus.util.xml.pull.MXParser.parseStartTag(MXParser.java:1776)
	at org.codehaus.plexus.util.xml.pull.MXParser.parseProlog(MXParser.java:1517)
	at org.codehaus.plexus.util.xml.pull.MXParser.nextImpl(MXParser.java:1436)
	at org.codehaus.plexus.util.xml.pull.MXParser.next(MXParser.java:1131)
	at org.apache.maven.model.io.xpp3.MavenXpp3ReaderEx.read(MavenXpp3ReaderEx.java:4399)
	at org.apache.maven.model.io.xpp3.MavenXpp3ReaderEx.read(MavenXpp3ReaderEx.java:598)
	at org.apache.maven.model.io.DefaultModelReader.read(DefaultModelReader.java:105)
	at org.apache.maven.model.io.DefaultModelReader.read(DefaultModelReader.java:82)
	at org.apache.maven.model.building.DefaultModelProcessor.read(DefaultModelProcessor.java:81)
	at org.apache.maven.model.building.DefaultModelBuilder.readModel(DefaultModelBuilder.java:535)
	at org.apache.maven.model.building.DefaultModelBuilder.build(DefaultModelBuilder.java:275)
	at org.apache.maven.project.DefaultProjectBuilder.build(DefaultProjectBuilder.java:429)
	at org.apache.maven.project.DefaultProjectBuilder.build(DefaultProjectBuilder.java:398)
	at org.apache.maven.project.DefaultProjectBuilder.build(DefaultProjectBuilder.java:361)
	at org.apache.maven.graph.DefaultGraphBuilder.collectProjects(DefaultGraphBuilder.java:400)
	at org.apache.maven.graph.DefaultGraphBuilder.getProjectsForMavenReactor(DefaultGraphBuilder.java:391)
	at org.apache.maven.graph.DefaultGraphBuilder.build(DefaultGraphBuilder.java:78)
	at org.apache.maven.DefaultMaven.buildGraph(DefaultMaven.java:511)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:221)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:194)
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:107)
```

## 漏洞概述

漏洞类型：bug

`java.lang.NullPointerException` 是一种运行时异常，表示程序尝试在没有对象实例的情况下访问对象的成员（方法或字段）。在你的情况下，这个异常发生在 Maven 的执行过程中。

从堆栈跟踪来看，异常发生在 `org.apache.maven.DefaultMaven.execute` 方法中，并且最终导致了 `org.apache.maven.InternalErrorException`。

使用 Maven 3.5.2 / plexus-utils 3.1.0 时，会引发内部错误：测试用例是具有不完整 XML 标记的pom.xml。

## 影响版本

maven 3.5.2， 3.5.3

修复版本 3.6.2
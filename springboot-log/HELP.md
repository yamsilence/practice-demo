日志分为日志门面和日志实现，日志门面定义了具体的规范，实现则是日志的具体实现

日志门面：Apache common-logging、Slf4j

日志实现：Log4j、Log4j2、Logback、Java Util Logging

日志级别：

Java Util Logging

Java Util Logging 定义了 7 个日志级别，从严重到普通依次是：

- SEVERE
- WARNING
- INFO
- CONFIG
- FINE
- FINER
- FINEST

因为默认级别是 INFO，因此 INFO 级别以下的日志，不会被打印出来。

Log4j

Log4j 定义了 8 个日志级别（除去 OFF 和 ALL，可以说分为 6 个级别），从严重到普通依次是：

- OFF：最高等级的，用于关闭所有日志记录。
- FATAL：重大错误，这种级别可以直接停止程序了。
- ERROR：打印错误和异常信息，如果不想输出太多的日志，可以使用这个级别。
- WARN：警告提示。
- INFO：用于生产环境中输出程序运行的一些重要信息，不能滥用。
- DEBUG：用于开发过程中打印一些运行信息。
- TRACE
- ALL 最低等级的，用于打开所有日志记录。

Logback

Logback 日志级别比较简单，从严重到普通依次是：

- ERROR
- WARN
- INFO
- DEBUG
- TRACE

Log4j 可以和 Apache Commons Logging 搭配使用，Apache Commons Logging 会自动搜索并使用 Log4j，如果没有找到 Log4j，再使用 Java Util Logging。

**比 Log4j + Apache Commons Logging 组合更得人心的是 Slf4j + Logback 组合。Logback 是 Slf4j 的原生实现框架，它也出自 Log4j 作者（Ceki Gülcü）之手，但是相比 Log4j，它拥有更多的优点、特性以及更强的性能。**
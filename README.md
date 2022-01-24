# schema-dp-maybe-bug

Create the CPB using:

    ./gradlew build -x test
    cordapp-builder create --cpk contracts/build/libs/corda5-template-contracts-1.0-SNAPSHOT-cordapp.cpk -o problem-cpb.cpb

When starting a DP1 node with this CPB, the following exception is thrown:

    ➜  node-1 java -jar corda.jar
    ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...

       ______               __
      / ____/     _________/ /___ _
     / /     __  / ___/ __  / __ `/         Rest in peace, boiled water.
    / /___  /_/ / /  / /_/ / /_/ /          You will be mist.
    \____/     /_/   \__,_/\__,_/

    --- Unknown 5.0.0-DevPreview-SNAPSHOT (21ca6d8) -------------------------------------------------------------


    Logs can be found in                    : /Users/joeldudley/Desktop/joel/node-1/logs
    [quasar] WARNING: Method not found in class - assuming suspendable: net/corda/v5/application/flows/UnexpectedFlowEndException#getMessage()Ljava/lang/String; (at FinalityFlow.kt:net/corda/systemflows/FinalityFlow#call)
    [quasar] WARNING: Method not found in class - assuming suspendable: net/corda/v5/application/flows/UnexpectedFlowEndException#getCause()Ljava/lang/Throwable; (at FinalityFlow.kt:net/corda/systemflows/FinalityFlow#call)
    [ERROR] 15:19:34+0000 [net.corda.node.OSGiNodeActivator.start] internal.NodeStartupLogging.invoke - Exception during node startup: Incompatible schema change detected. Please run schema migration scripts (node with sub-command run-migration-scripts). Reason: Schema-validation: missing table [AUTH] {}
    net.corda.internal.persistence.HibernateSchemaChangeException: Incompatible schema change detected. Please run schema migration scripts (node with sub-command run-migration-scripts). Reason: Schema-validation: missing table [AUTH]
      at net.corda.impl.persistence.factory.CordaPersistenceFactoryImpl$createCordaPersistence$1.apply(CordaPersistenceFactoryImpl.kt:76)
      at net.corda.impl.persistence.factory.CordaPersistenceFactoryImpl$createCordaPersistence$1.apply(CordaPersistenceFactoryImpl.kt:20)
      at java.base/java.util.HashMap.computeIfAbsent(HashMap.java:1133)
      at net.corda.impl.persistence.factory.CordaPersistenceFactoryImpl.createCordaPersistence(CordaPersistenceFactoryImpl.kt:59)
      at net.corda.node.internal.AbstractNodeKt.createCordaPersistence(AbstractNode.kt:1394)
      at net.corda.node.internal.AbstractNode.<init>(AbstractNode.kt:384)
      at net.corda.node.internal.AbstractNode.<init>(AbstractNode.kt:277)
      at net.corda.node.internal.Node.<init>(Node.kt:111)
      at net.corda.node.internal.Node.<init>(Node.kt:110)
      at net.corda.node.internal.NodeStartup.createNode(NodeStartup.kt:287)
      at net.corda.node.internal.NodeStartup.access$createNode(NodeStartup.kt:142)
      at net.corda.node.internal.NodeStartup$initialiseAndRun$9.invoke(NodeStartup.kt:219)
      at net.corda.node.internal.NodeStartup$initialiseAndRun$9.invoke(NodeStartup.kt:142)
      at net.corda.node.internal.NodeStartupLogging.attempt(NodeStartup.kt:608)
      at net.corda.node.internal.NodeStartup.initialiseAndRun(NodeStartup.kt:217)
      at net.corda.node.internal.NodeStartupCli.runProgram(NodeStartup.kt:133)
      at net.corda.cliutils.CordaCliWrapper.call(CordaCliWrapper.kt:210)
      at net.corda.node.internal.NodeStartupCli.call(NodeStartup.kt:118)
      at net.corda.node.internal.NodeStartupCli.call(NodeStartup.kt:92)
      at picocli.CommandLine.executeUserObject(CommandLine.java:1933)
      at picocli.CommandLine.access$1200(CommandLine.java:145)
      at picocli.CommandLine$RunLast.executeUserObjectOfLastSubcommandWithSameParent(CommandLine.java:2332)
      at picocli.CommandLine$RunLast.handle(CommandLine.java:2326)
      at picocli.CommandLine$RunLast.handle(CommandLine.java:2291)
      at picocli.CommandLine$AbstractParseResultHandler.execute(CommandLine.java:2159)
      at picocli.CommandLine.execute(CommandLine.java:2058)
      at net.corda.cliutils.CordaCliWrapperKt.start(CordaCliWrapper.kt:114)
      at net.corda.node.OSGiNodeActivator$start$1.invoke(OSGiNodeActivator.kt:45)
      at net.corda.node.OSGiNodeActivator$start$1.invoke(OSGiNodeActivator.kt:19)
      at kotlin.concurrent.ThreadsKt$thread$thread$1.run(Thread.kt:30)
    Caused by: org.hibernate.tool.schema.spi.SchemaManagementException: Schema-validation: missing table [AUTH]
      at org.hibernate.tool.schema.internal.AbstractSchemaValidator.validateTable(AbstractSchemaValidator.java:121)
      at org.hibernate.tool.schema.internal.GroupedSchemaValidatorImpl.validateTables(GroupedSchemaValidatorImpl.java:42)
      at org.hibernate.tool.schema.internal.AbstractSchemaValidator.performValidation(AbstractSchemaValidator.java:89)
      at org.hibernate.tool.schema.internal.AbstractSchemaValidator.doValidation(AbstractSchemaValidator.java:68)
      at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:192)
      at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:73)
      at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:318)
      at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:468)
      at net.corda.impl.persistence.factory.BaseSessionFactoryProvider.buildSessionFactory(BaseSessionFactoryProvider.kt:85)
      at net.corda.impl.persistence.factory.H2SessionFactoryProvider.buildSessionFactory(H2SessionFactoryProvider.kt:25)
      at net.corda.impl.persistence.factory.BaseSessionFactoryProvider.makeSessionFactoryForSchemas(BaseSessionFactoryProvider.kt:114)
      at net.corda.impl.persistence.HibernateContext.makeSessionFactoryForSchemas(HibernateContext.kt:76)
      at net.corda.impl.persistence.HibernateContext.access$makeSessionFactoryForSchemas(HibernateContext.kt:26)
      at net.corda.impl.persistence.HibernateContext$sessionFactoryForSchemas$1.invoke(HibernateContext.kt:73)
      at net.corda.impl.persistence.HibernateContext$sessionFactoryForSchemas$1.invoke(HibernateContext.kt:26)
      at net.corda.impl.persistence.HibernateContext$sam$java_util_function_Function$0.apply(HibernateContext.kt)
      at com.github.benmanes.caffeine.cache.BoundedLocalCache.lambda$doComputeIfAbsent$13(BoundedLocalCache.java:2439)
      at java.base/java.util.concurrent.ConcurrentHashMap.compute(ConcurrentHashMap.java:1908)
      at com.github.benmanes.caffeine.cache.BoundedLocalCache.doComputeIfAbsent(BoundedLocalCache.java:2437)
      at com.github.benmanes.caffeine.cache.BoundedLocalCache.computeIfAbsent(BoundedLocalCache.java:2420)
      at com.github.benmanes.caffeine.cache.LocalCache.computeIfAbsent(LocalCache.java:104)
      at com.github.benmanes.caffeine.cache.LocalManualCache.get(LocalManualCache.java:62)
      at net.corda.impl.persistence.HibernateContext.sessionFactoryForSchemas(HibernateContext.kt:73)
      at net.corda.impl.persistence.HibernateContext.<init>(HibernateContext.kt:69)
      at net.corda.impl.persistence.factory.CordaPersistenceFactoryImpl$createCordaPersistence$1.apply(CordaPersistenceFactoryImpl.kt:73)
      ... 29 more

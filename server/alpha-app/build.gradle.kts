dependencies {
    compileOnly(genesis("script-dependencies"))
    genesisGeneratedCode(withTestDependency = true)
    testImplementation("global.genesis:genesis-dbtest")
    testImplementation("global.genesis:genesis-testsupport")
    testImplementation("global.genesis:genesis-dataserver2")
    testImplementation("global.genesis:genesis-pal-dataserver")
}

description = "alpha-app"

sourceSets {
    main {
        resources {
            srcDirs("src/main/resources", "src/main/genesis")
        }
    }
}

tasks {
    copyDependencies {
        enabled = false
    }
    test {
        systemProperty("DbLayer", "SQL")
        systemProperty("DbHost", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")
        systemProperty("DbQuotedIdentifiers", "true")
    }
}

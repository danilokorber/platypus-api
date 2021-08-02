package io.easyware.platypus.util;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MySQLContainer;

import java.util.HashMap;
import java.util.Map;

public class MySqlTestResource implements QuarkusTestResourceLifecycleManager {

    private final static String DB_IMAGE = "mysql:5.5";

    private MySQLContainer<?> db;

    @Override
    public Map<String, String> start() {
        db = new MySQLContainer<>(DB_IMAGE);
        db.start();
        return configurationParameters();
    }

    @Override
    public void stop() {
        db.stop();
    }

    private Map<String, String> configurationParameters() {
        Map<String, String> conf = new HashMap<>();
        conf.put("quarkus.datasource.jdbc.url", db.getJdbcUrl());
        conf.put("quarkus.datasource.username", db.getUsername());
        conf.put("quarkus.datasource.password", db.getPassword());
        return conf;
    }
}

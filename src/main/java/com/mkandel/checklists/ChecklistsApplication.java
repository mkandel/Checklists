package com.mkandel.checklists;

import com.mkandel.checklists.utils.Routes;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class ChecklistsApplication {

	final
	Routes routes;

	@Autowired
	public ChecklistsApplication(DataSource dataSource, Routes routes) {
		this.routes = routes;
		this.routes.Init();
		runFlyway(dataSource);
	}

	public static void main(String[] args) {
		SpringApplication.run(ChecklistsApplication.class, args);
	}

	@Bean
	public FlywayMigrationStrategy migrationStrategy() {
		return Flyway::validate;
	}

	private void runFlyway(DataSource datasource) {
		// Playing with reading properties from application.yml
		//  TODO: Clean this up eventually
		Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());
		logger.info("*** routes.BASE: " + routes.BASE + " ***");

		Flyway
				.configure()
				.dataSource(datasource)
				//  This is actually kinda silly and took me quite a while to get right.
				.table("flyway_migration_history")
				//  Ideally, I wanted `flyway_migration_history` to reside in `flyway_history_schema`
				//    but the "real" tables I wanted in `checklists`, I tried all kinds of combinations here:
				.schemas("checklists", "flyway_history_schema")
				//  If I change the order of schemas here, it breaks ...
				.defaultSchema("flyway_history_schema")
				//  If I do the logical thing and use `checklists` as the default schema, it breaks ...
				//  But everything works fine like this and ...
				.initSql("CREATE SCHEMA IF NOT EXISTS flyway_history_schema;")
				//  Even though the empty `checklists` schema has to already exist, creating
				//    `flyway_history_schema` here works fine which is great!
				.locations("classpath:db/migration")
				.baselineOnMigrate(true)
				.validateOnMigrate(true)
				.repeatableSqlMigrationPrefix("R")
				.sqlMigrationPrefix("V")
				.load()
				.migrate();
	}
}

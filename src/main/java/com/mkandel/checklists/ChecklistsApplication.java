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
		Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());
		logger.info("*** routes.BASE: " + routes.BASE + " ***");

		// Run Flyway migration/validation
		Flyway
				.configure()
				.dataSource(datasource)
				.table("flyway_migration_history")
				.locations("classpath:db/migration")
				.baselineOnMigrate(true)
				.validateOnMigrate(true)
				.repeatableSqlMigrationPrefix("R")
				.sqlMigrationPrefix("V")
				.load()
				.migrate();
	}
}

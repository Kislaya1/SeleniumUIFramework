package com.auto.selenium.ui.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "system:env",
  "file:${user.dir}/src/test/resources/env.properties"
})
public interface IEnvConfig extends Config {
  @DefaultValue("10000")
  String waitTime();

  @DefaultValue("chrome")
  String browser();

  @DefaultValue("prod")
  String environment();

  @Key("${environment}_url")
  String webUrl();

  @Key("${environment}_username")
  String username();

  @Key("${environment}_password")
  String password();
}

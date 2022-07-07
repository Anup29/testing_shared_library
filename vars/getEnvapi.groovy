def getEnvapi(String env) {
    if(env.contains("stg")) {return "stg.skyscraper.vmware.com";
    } else if(env.contains("dev")) {return "dev.skyscraper.vmware.com";
    } else { return "PROD"; }
}

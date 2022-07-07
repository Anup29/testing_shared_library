def call(String env) {
    if(env.contains("stg")) { return "STG";
    } else if(env.contains("dev")) { return "DEV";
    } else { return "PROD"; }
}

import static calc.*

def call(String env) {
    def r = calc.sub(10,5)
    println(r)
    if(env.contains("stg")) { return "STG";
    } else if(env.contains("dev")) { return "DEV";
    } else { return "PROD"; }
}

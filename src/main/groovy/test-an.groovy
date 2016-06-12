import java.text.SimpleDateFormat

long time = 1461204000000

long hours = (new Date().getTime() - time) / (3600 * 1000)
boolean moreThen1day = false

if(hours >= 24) {
    moreThen1day = true
}

println moreThen1day


SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
Date date = sdf.parse( " 2016-05-30 09:20:00 " );
println date.hours
println date.minutes
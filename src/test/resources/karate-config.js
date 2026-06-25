function fn() {
    var config = {
        baseUrl: 'https://api.demoblaze.com',
    };

    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    karate.configure('logPrettyRequest', true);
    karate.configure('logPrettyResponse', true);

    return config;
}
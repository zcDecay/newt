
/*var GlobalConfig = { BASE_PATH : '/' };*/
if (!window.GlobalConfig) {
    window.GlobalConfig = {
        BASE_PATH: ''
    }
}
if (window.requirejs) {
    requirejs.config({
        // By default load any module IDs from js/lib
        basePath: './static/js',
        urlArgs: '',// "bust=" + (new Date()).getTime()
        waitSeconds: 200,
        paths: {
            // app : '../app',
            'jquery': 'lib/jquery-1.12.1.min',
            'jqlazyload': 'lib/jquery.lazyload.min',
            'unslider': 'lib/unslider.min',
            'mui': 'lib/mui'
        },
        shim: {
            'jqlazyload': {
                deps: ['jquery']
            },
            'unslider': {
                deps: ['jquery']
            },
            'mui': {
                deps: ['jquery']
            }
        }
    });
}
// see http://vuejs-templates.github.io/webpack for documentation.
var path = require('path')

module.exports = {
  build: {
    env: require('./prod.env'),
    index: path.resolve(__dirname, '../dist/index.html'),
    assetsRoot: path.resolve(__dirname, '../dist'),
    assetsSubDirectory: 'static',
    assetsPublicPath: './',
    productionSourceMap: true,
    // Gzip off by default as many popular static hosts such as
    // Surge or Netlify already gzip all static assets for you.
    // Before setting to `true`, make sure to:
    // npm install --save-dev compression-webpack-plugin
    productionGzip: false,
    productionGzipExtensions: ['js', 'css'],
    // Run the build command with an extra argument to
    // View the bundle analyzer report after build finishes:
    // `npm run build --report`
    // Set to `true` or `false` to always turn it on or off
    bundleAnalyzerReport: process.env.npm_config_report
  },
  dev: {
    env: require('./dev.env'),
    port: 8033,
    autoOpenBrowser: true,
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',
    proxyTable: {
      '/auth': {
        target: 'http://127.0.0.1:17001',
        changeOrigin: true,
        pathRewrite: {
          '^/auth': '/auth'
        },
        secure: false
      },
      '/buss': {
        target: 'http://127.0.0.1:17002',
        changeOrigin: true,
        pathRewrite: {
          '^/buss': '/buss'
        },
        secure: false
      },
      '/list': {
        target: 'http://hq.sinajs.cn',
        changeOrigin: true,
        pathRewrite: {
          '^/list': '/list'
        },
        secure: false

      },
      '/hisHq': {
        target: 'http://q.stock.sohu.com',
        changeOrigin: true,
        pathRewrite: {
          '^/hisHq': '/hisHq'
        },
        secure: false
      },
      '/flashdata': {
        target: '  http://data.gtimg.cn',
        changeOrigin: true,
        pathRewrite: {
          '^/flashdata': '/flashdata'
        },
        secure: false
      }
    },
    // CSS Sourcemaps off by default because relative paths are "buggy"
    // with this option, according to the CSS-Loader README
    // (https://github.com/webpack/css-loader#sourcemaps)
    // In our experience, they generally work as expected,
    // just be aware of this issue when enabling this option.
    cssSourceMap: false
  }
}

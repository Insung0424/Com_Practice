const { createProxyMiddleware } = require('http-proxy-middleware')

module.exports = app => {
    app.use('proxy',
    createProxyMiddleware({
        target : 'http://testbackpage.com/',
        changeOrigin : true,
    }))
}
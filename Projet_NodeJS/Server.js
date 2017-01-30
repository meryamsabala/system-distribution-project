var express=require("express");
var app=express();
var http=require("http");
var httpServer=http.createServer(app);
var io=require("socket.io").listen(httpServer);
var bodyParser=require("body-parser");
var bodyParser=require('body-parser');
app.use(bodyParser.json());
app.use(express.static('public'));
app.get('/',function(req,resp){
	resp.sendfile('public/index.html');
});
io.on('connection', function(socket) {
    socket.on('chargerSociete', function (data) {
        var options = {
            host: 'localhost',
            port: 8080,
            path: '/societe/' + data.code
        };
        http.get(options, function(resp){
            body = '';
            resp.on('data', function(d){
                body += d;
            }).on('end', function(){
                var parsed = JSON.parse(body);
                socket.emit('societeLoaded',{'societe':parsed});
            });
        }).on("error", function(e){
            console.log("Erreur : " + e.message);
        });
    });
    socket.on('chargerOrdres', function (data) {
        var options = {
            host: 'localhost',
            port: 8080,
            path: '/PageOrdres?code=' + data.code + '&page=' + data.page + '&size=' + data.size
        };
        http.get(options, function(resp){
            body = '';
            resp.on('data', function(d){
                body += d;
            }).on('end', function(){
                var parsed = JSON.parse(body);
                console.log(parsed);
                socket.emit('ordresLoaded',{'ordres':parsed.content,'totalPages':parsed.totalPages});
            });
        }).on("error", function(e){
            console.log("Erreur : " + e.message);
        });
    });
});  
httpServer.listen(8081,function(){
	console.log("Démarrage sur le port 8081 .....");
});
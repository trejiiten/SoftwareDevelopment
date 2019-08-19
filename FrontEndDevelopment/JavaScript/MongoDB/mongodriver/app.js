const MongoClient = require('mongodb').MongoClient;

//connection url

const url = 'mongodb://localhost:27017/myproject';

MongoClient.connect(url, function(err, db) {
  if (err) {
    return console.dir(err);
  }
  console.log('Connected to mongodb');

  /*InsertDocument(db, function(){
    db.close();
  });
  InsertDocuments(db, function(){
    db.close();
  });
  FindDocuments(db, function(){
    db.close();
  });
  QueryDocuments(db, function(){
    db.close();
  });
  UpdateDocument(db, function() {
    db.close();
  });*/

  RemoveDocument(db, function() {
    db.close();
  });
});


//Insert Single Doc
const InsertDocument = function(db, callback) {
  //get Collection
  const collection = db.collection('users');
  //insert docs
  collection.insert({
    name: 'Todd Rings',
    email: 'trejiiten@gmail.com'
  }, function(err, result) {
    if (err) {
      return console.dir(err);
    }
    console.log('Inserted Document');
    console.log(result);
    callback(result);
  });
}


//insert multiple documents
const InsertDocuments = function(db, callback) {
  //get collection
  const collection = db.collection('users');
  collection.insertMany([{
      name: "John Scott",
      email: "papajohn@yahoo.com"
    },
    {
      name: "Antony Ko",
      email: "antonyko@yahoo.com"
    },
    {
      name: "Todd Rings",
      email: "monodrommdm@yahoo.com"
    },
  ], function(err, result) {
    if (err) {
      return console.dir(err);
    }
    console.log('Inserted ' + result.ops.length + ' documents');
    //console.log(result);
    callback(result);
  });
}

//Find documents
const FindDocuments = function(db, callback) {
  //get collection
  const collection = db.collection('users');

  collection.find({}).toArray(function(err, docs) {
    if (err) {
      return console.dir(err);
    }
    console.log('Found the following records');
    console.log(docs);
    callback(docs);
  });
}

//Query document
const QueryDocuments = function(db, callback) {
  //get collection
  const collection = db.collection('users');
  collection.find({
    'name': 'Todd Rings'
  }).toArray(function(err, docs) {
    if (err) {
      return console.dir(err);
    }
    console.log('Found the following records');
    console.log(docs);
    callback(docs);
  });
}


//Update documents
const UpdateDocument = function(db, callback) {
  //get collection
  const collection = db.collection('users');
  collection.updateOne({
    name: 'John Scott'
  }, {
    $set: {
      email: 'johnscott@gmail.com'
    }
  }, function(err, result) {
    if (err) {
      return console.dir(err);
    }
    console.log('Updated Document');
    callback(result);
  });

}


//Remove Document
const RemoveDocument = function(db, callback){
  const collection = db.collection('users');

  collection.deleteOne({name: 'Todd Rings'}, function(err, result){
  }, function(err, result) {
    if (err) {
      return console.dir(err);
    }
    console.log('Removed Document');
    console.log(result);
    callback(result);
  });
}

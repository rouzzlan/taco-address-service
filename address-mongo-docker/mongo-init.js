db.createUser(
    {
        user: "rouslan",
        pwd: "50m9FiD3",
        roles: [
            {
                role: "readWrite",
                db: "addressdb"
            }
        ]
    }
);

db = new Mongo().getDB('addressdb');

db.createCollection('Address');

db.Address.insertMany([
    {
        "_id": ObjectId("644874b3777555522fd294ca"),
        "city": "Emblem",
        "country": "BE",
        "hash": "c49a20095a4f5ac6f83a3c0ff33854327b1cf3c2c5b39aa6f934c1fe53c1dd61",
        "state": "Antwerpen",
        "street": "Kloosterstraat 27A",
        "zip": "2520"
    }
]);
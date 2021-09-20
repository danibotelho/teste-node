const express = require('express');
const cors = require('cors');
const toDoRoutes = require('./routes/route');
const db = require('./data/database');

const app = express();


app.use(cors());
app.use(express.json());
db.connect();

app.use('/', toDoRoutes);

app.get('/', async (req,res) => {
    res.json({
    "name": "Teste Node",
    "version": "1.0.0",
    "description": " "
    });
})

module.exports = app
const express = require('express');
const cors = require('cors');
const toDoRoutes = require('./routes/route')
const db = require('./data/database')

const app = express();


app.use(cors());
app.use(express.json());
db.connect()

app.use('/', toDoRoutes)

module.exports = app
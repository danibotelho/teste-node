
const mongoose = require('mongoose')
const toDoSchema = new mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,

    titulo:{
        type: String,
        require: true
    },

    descricao:{
        type: String,
        require: true
    },

    done:{
        type: Boolean,
        require: true
    }

})

module.exports = mongoose.model('toDOList',toDoSchema )
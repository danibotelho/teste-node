
const mongoose = require('mongoose');
const toDoList = require('../models/toDoList');        

 
const getAll = async (req, res) =>{
    const toDo = await toDoList.find();
    return res.status(200).send({toDo});
    
}

const create = async (req, res) => {
    const toDo = new toDoList({
        _id: new mongoose.Types.ObjectId,
        titulo: req.body.titulo,
        descricao: req.body.descricao,
        done: req.body.done
            
    });
        const novaTarefa = await toDo.save();
        res.status(201).json({
            novaTarefa,
            message:"Cadastrado com sucesso."
           });
    }


 const getId = async (req, res) => {
    const idReq = await toDoList.findById(req.params.id);
        res.status(200).json(idReq);
     }



 const updateList = async (req, res) => {
    const idReq = await toDoList.findById(req.params.id);
   
    if(idReq == null) {
        return res.status(404).json({message: 'ID não encontrado.'});
    }
    if (req.body.titulo != null) {
        idReq.titulo = req.body.titulo
    }
    if (req.body.descricao != null) {
        idReq.descricao = req.body.descricao
    }
    if (req.body.done != null) {
        idReq.done = req.body.done
    }
    try {        
        const tarefaAtualizada = await idReq.save()
       res.status(200).json({tarefaAtualizada,
            message: "Cadasro Atualizado com Sucesso."
        });

    } catch (err) {
        res.status(500).json({ message: err.message})
    }
}

const deleteList = async (req, res) => {
    const idReq = await toDoList.findById(req.params.id);;

    if(idReq != null) {
    await idReq.remove();
    res.status(200).json({message: 'Cadastro Deletado'});
    }
}


module.exports = {
    getAll,
    create,
    getId,
    updateList,
    deleteList

}
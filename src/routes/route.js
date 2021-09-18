const express = require('express');
const router = express.Router()
const Controller = require('../controllers/controller');


router.get('/issue', Controller.getAll);
router.post('/issue', Controller.create);

router.get('/issue/:id', Controller.getId);
router.post('/issue/:id', Controller.updateList)

router.delete('/issue/:id', Controller.deleteList);

module.exports = router
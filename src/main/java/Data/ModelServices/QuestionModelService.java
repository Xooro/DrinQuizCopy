/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.ModelServices;

import Data.ModelServices.Base.BaseModelService;
import Models.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkris
 */
public class QuestionModelService extends BaseModelService {

    @Override
    public void add(Object modelToAdd) {
        Question questionToAdd = (Question)modelToAdd;
    }

    @Override
    public void update(Object modelToUpdate) {
        Question questionToUpdate = (Question)modelToUpdate;
    }

    @Override
    public void remove(Object modelToRemove) {
        Question questionToRemove = (Question)modelToRemove;
    }

    @Override
    public List<Object> GetAll() {
        return new ArrayList<Object>();
    }
}
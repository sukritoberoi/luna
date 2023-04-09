from fastapi import FastAPI
from pydantic import BaseModel
import numpy as np
import pickle
import pandas as pd
from sklearn import *


app = FastAPI()

class cycle(BaseModel):
     cycle_number : int
     number_of_peak : int
     Age	 : int
     Estimated_day_of_ovulution	 : int
     Length_of_Leutal_Phase	 : int
     Length_of_menses:int	
     Unusual_Bleeding: int	
     Income	 : int
     BMI	 : int
     Mean_of_length_of_cycle : int	
     Menses_score : int

     

@app.get('/')
async def home():
    return {'HELLO':'WORLD'}

pickle_in = open("regression.pkl","rb")
le= pickle.load(pickle_in)

@app.post('/predict')
def predict_cycle(data:cycle):
    data = data.dict()
    cycle_number=data['cycle_number']
    number_of_peak=data['number_of_peak']
    Age=data['Age']
    Estimated_day_of_ovulution=data['Estimated_day_of_ovulution']
    Length_of_Leutal_Phase=data['Length_of_Leutal_Phase']
    Length_of_menses=data['Length_of_menses']
    Unusual_Bleeding =data['Unusual_Bleeding']
    Income = data['Income']
    BMI = data['BMI']
    Mean_of_length_of_cycle = data ['Mean_of_length_of_cycle']
    Menses_score = data['Menses_score']

   # print(classifier.predict([[variance,skewness,curtosis,entropy]]))
    reg_pred = le.predict([[cycle_number,number_of_peak,Age,Estimated_day_of_ovulution,Length_of_Leutal_Phase,Length_of_menses,Unusual_Bleeding,Income,BMI,Mean_of_length_of_cycle,Menses_score
]])
    final = np.mean(reg_pred)
    if(final<30):
        period='NO PCOD RISK'
    else:
        period='PCOD RISK IS HIGH'
    return {'period': period }


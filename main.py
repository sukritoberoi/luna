from flask import Flask,request,jsonify
import pickle
import numpy as np


lunamodel=pickle.load(open('lunamodel.pkl','rb'))
app=Flask(__name__)
@app.route('/')
def home():
    return "Welcome to luna"
@app.route('/predict',methods=['POST'])
def predict():
    cycle_number=int(request.form.get('cycle_number'))
    number_of_peak=int(request.form.get('number_of_peak'))
    Age=int(request.form.get('Age'))
    Length_of_cycle=int(request.form.get('Length_of_cycle'))
    Estimated_day_of_ovulution=int(request.form.get('Estimated_day_of_ovulution'))
    Length_of_Leutal_Phase=int(request.form.get('Length_of_Leutal_Phase'))
    Length_of_menses=int(request.form.get('Length_of_menses'))
    Weight=int(request.form.get('Weight'))
    BMI=float(request.form.get('BMI'))
    Mean_of_length_of_cycle=int(request.form.get('Mean_of_length_of_cycle'))
    Menses_score=float(request.form.get('Menses_score'))

    input_query = np.array([[cycle_number, number_of_peak, Age, Length_of_cycle, Estimated_day_of_ovulution,Length_of_Leutal_Phase, Length_of_menses, Weight, BMI, Mean_of_length_of_cycle,Menses_score]])
    result=lunamodel.predict(input_query)[0]
    return jsonify(int(result))

if __name__=='__main__':
    app.run(debug=True)
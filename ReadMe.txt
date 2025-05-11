Brain Tumor Analysis Project
============================

Contributors:
- Abraham Duarte
- William J Faircloth
- Kishan Bhagwandas
- Johnny Doan

Institution: Clayton State University  
Semester: Spring 2025  
Academic Advisor: Dr. Ken Nguyen

Overview:
---------
This project builds upon the work found at the following GitHub repository:  
https://github.com/marcotallone/deep-learning-project

Please refer to the original project for a complete view of the base implementation, to identify changes we've made, and to explore potential areas for further improvement.

MRiLab:
-----------------------------
The information for the Brain Phantom Generator can be found here 
https://github.com/leoliuf/MRiLab

Please note that this requires MATLAB to be able to run. Please ask your Academic Advisor for ways to gain academic access. 

Directory and File Structure:
-----------------------------

- **Dataset**: Contains files for classification, segmentation, and the camera system. A Python script is provided to download the required datasets for classification and segmentation, and to create the necessary subfolders.

- **GRADIO**: Contains the Python script to run the Gradio interface.

- **JOB**: Stores job files related to model execution.

- **Models**: Contains Python scripts for model construction, as well as subfolders for saved models and their metrics.

- **Notebooks**: Includes Jupyter notebooks that walk you through model training.

- **PredictionDatasets**: Contains files used for predictions. These are based on the 2021 BraTS dataset and are not seen by the model during training. 
  - `dataDownload.py`: Downloads the 2021 dataset.
  - `fileMoving.py`: Organizes patient data into subfolders for the camera system.
  - `niitopng.py`: Converts .nii files to PNGs for classification.
    - Documentation: https://github.com/SerkanSavas/niitopng

- **Training**: Contains training parameters for the U-Net model.

- **UTILS**: Contains utility scripts for generating graphs within the Jupyter notebooks.

Instructions to Use the System:
-------------------------------

1. **Set up a Virtual Environment**  
   Use a Windows virtual environment for simplicity. Install dependencies using the `requirements.txt` file.

2. **Download Training and Validation Datasets**  
   Navigate to the `Dataset` folder. Modify the dataset script to match your local directory. Download the required datasets from Kaggle. Note: You may need a Kaggle account.

3. **Train the Models**  
   Open and execute the Jupyter notebooks. These guide you through training the classification and segmentation models. Training is necessary to utilize the Gradio interface effectively.

4. **Run the Gradio Interface**  
   Navigate to the `GRADIO` folder and execute the interface script. Adjust the model import paths as needed. Learn more about Gradio at:  
   https://www.gradio.app

   The Gradio script also includes:
   - Examples of how to make predictions.
   - Integration with the camera system.

For help on the camera system contact William "Josh" Fiarcloth on githib here : https://github.com/Kidtruck91

For help on the models, contact Abraham Duarte through email _ abe.d.perdomo@gmail.com
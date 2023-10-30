import pandas as pd
import numpy as np

# holiday_events = pd.read_csv("/Volumes/External_HD/Arquivos/PythonDataSets/store-sales-time-series-forecasting/holidays_events.csv", sep=",")
# oil = pd.read_csv("/Volumes/External_HD/Arquivos/PythonDataSets/store-sales-time-series-forecasting/oil.csv", sep=",")
# stores = pd.read_csv("/Volumes/External_HD/Arquivos/PythonDataSets/store-sales-time-series-forecasting/stores.csv", sep=",")
# transactions = pd.read_csv("/Volumes/External_HD/Arquivos/PythonDataSets/store-sales-time-series-forecasting/transactions.csv", sep=",")

looqbox_log = pd.read_csv("/Users/antoniogally/Downloads/hdi_logs.csv", sep=";")

filtered_df = looqbox_log[looqbox_log["Status"] == "suggestion"]

unique_users = set(filtered_df["Id"])

for userId in unique_users:
    user_df = looqbox_log[looqbox_log["Id"] == userId]

    # 5. Convert the `Data` column to the "dd/mm/yyyy" format.
    user_df["Data"] = pd.to_datetime(user_df["Data"]).dt.strftime("%d/%m/%Y  %H:%M:%S")

    # Writing to a new CSV file named after the UserID.
    user_df = user_df.drop(["Usuario", "Id", "Empresa", "Resposta"], axis=1)
    user_df.to_csv(f"./csv/user_{userId}.csv", sep=";", index=False)
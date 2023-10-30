import pandas as pd

df = pd.read_csv("/Users/antoniogally/Downloads/CarPrice_Assignment.csv")

marca = []
for indice in range(0,len(df)):
  marca.append(df.CarName[indice].split()[0])

df['marca'] = marca

contagem_dicionario = dict(df.marca.value_counts())

df.loc[(df.marca == 'Nissan'), 'marca'] = 'nissan'
df.loc[(df.marca.isin(['vokswagen','vw'])), 'marca'] = 'volkswagen'

marca = list(df.marca)

marca2 = []
for idx in range(0,len(marca)):
  if dict(df.marca.value_counts())[marca[idx]] < int(len(df)*0.05):
    marca2.append('outros')
  else:
    marca2.append(marca[idx])


df['marca2'] = marca2
print(df.marca.unique())
print(df.marca2.unique())
import pandas as pd
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix, classification_report
import seaborn as sns
import matplotlib.pyplot as plt

pd.set_option('display.max_rows', None)
pd.set_option('future.no_silent_downcasting', True)

df = pd.read_csv('train.csv')

def get_deck(cabin):
    if pd.isna(cabin):
        return None
    else:
        return cabin.split()[0][0]

df['Age'] = df['Age'].fillna(round(df['Age'].mean()))
df['Deck'] = df['Cabin'].apply(get_deck)
df['Deck'] = df['Deck'].fillna('X')
df = pd.get_dummies(df, columns=['Deck', 'Name', 'Ticket', 'Embarked'])
df['Sex'] = df['Sex'].replace({'female': 0, 'male': 1})
df = df.drop(['Cabin'], axis=1)
X = df.drop(['Survived',], axis=1)
y = df['Survived']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

knn = KNeighborsClassifier(n_neighbors=3)

knn.fit(X_train, y_train)

print(knn.score(X_test, y_test))

y_pred = knn.predict(X_test)

# Matriz de Confusão
cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['Não Sobreviveu', 'Sobreviveu'], yticklabels=['Não Sobreviveu', 'Sobreviveu'])
plt.xlabel('Predito')
plt.ylabel('Verdadeiro')
plt.title('Matriz de Confusão')
plt.show()

# Relatório de Classificação
print(classification_report(y_test, y_pred, target_names=['Não Sobreviveu', 'Sobreviveu']))
# Содержание
1. [Добавление книги](#1)
2. [Удаление книги](#2)
3. [Поиск книг](#3)
4. [Выбор варианта сортировки](#4)
5. [Выбор критерия сортировки](#5)
6. [Открытие книги](#6)

### 1. Добавление книги<a name="1"></a>
При нажатии кнопки со знаком "+" появится сцена добавления книг, в которой пользователю необходимо будет заполнить такие поля, как "Название", "Автор", "Жанр", "Настроение", выставить книге оценку, добавить файл произведения. Для добавления книги в список необходимо нажать кнопку с символом "+". Для отмены операции необходимо нажать кнопку с символом стрелки влево.

![Добавление книги](https://github.com/desmond1999d/MyLib/blob/master/Documentation/UMLDiagrams/ActivityDiagrams/AddBookActivity.png)

### 2. Удаление книги<a name="2"></a>
При нажатии кнопки с символом "-" выбранная книга будет удалена из списка книг. 

![Удаление книги](https://github.com/desmond1999d/MyLib/blob/master/Documentation/UMLDiagrams/ActivityDiagrams/DeleteBookActivity.png)
  
### 3. Поиск книг<a name="3"></a>
При нажатии на кнопку с символом "лупа" будет произведен поиск записей списка книг, основываясь на предварительно введенной пользователем в поле ввода слева от указанной кнопки информации. Результат поиска будет отображен в окне списка книг справа.

![Поиск книг](https://github.com/desmond1999d/MyLib/blob/master/Documentation/UMLDiagrams/ActivityDiagrams/SearchForBooksActivity.png)

### 4. Выбор варианта сортировки<a name="4"></a>
При выборе варианта сортировки из выпадающего списка с текстом "Sort by" в выпадающем списке с текстом "Criterion" будут отображены возможные критерии сортировки.

![Выбор варианта сортировки](https://github.com/desmond1999d/MyLib/blob/master/Documentation/UMLDiagrams/ActivityDiagrams/SortVariantActivity.png)

### 5. Выбор критерия сортировки<a name="5"></a>
При выборе критерия сортировки из выпадающего списка с текстом "Criterion" в поле отображения списка книг будет показан список книг, отсортированный в соответствии с выбранным вариантом и критерием сортировки.

![Выбор критерия сортировки](https://github.com/desmond1999d/MyLib/blob/master/Documentation/UMLDiagrams/ActivityDiagrams/SortCriterionActivity.png)

### 6. Открытие книги<a name="6"></a>
При двойном нажатии мыши по элементу списка книг будет произведено открытие файла книги в стороннем приложении, способном открыть файлы заданного формата. Если файл не будет найден, будет выведено предупреждающее об этом сообщение. Если программа, способная открыть файл заданного формата не будет найдена, будет выведено предупреждающее об этом сообщение.

![Открытие книги](https://github.com/desmond1999d/MyLib/blob/master/Documentation/UMLDiagrams/ActivityDiagrams/OpenBookActivity.png)
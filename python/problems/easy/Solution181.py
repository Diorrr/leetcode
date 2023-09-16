import pandas as pd

def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
    return employee.merge(employee, left_on='managerId', right_on='id').query("salary_x > salary_y")['name_x'].to_frame('Employee')

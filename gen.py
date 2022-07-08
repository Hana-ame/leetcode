a = ["RangeModule","addRange","queryRange","addRange","queryRange","addRange","removeRange","removeRange","removeRange","queryRange"]
b = [[],[5,7],[2,7],[6,9],[2,9],[2,7],[3,10],[1,8],[1,10],[4,7]]

def help(b:list):
    for i in range(len(b)):
        if isinstance(b,str):
            b[i] = f'"{b[i]}"'
        else:
            b[i] = f'{b[i]}'
    return b

for i in range(len(a)):
    print(f"obj.{a[i]}({','.join(help(b[i]))});")
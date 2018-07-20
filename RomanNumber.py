def intToRoman(num):

    if num < 1 or num > 3999: return ""

    output = ""
    while num > 0:
        if num >= 1000:
            output += "M"
            num -= 1000
        else:
            if num >= 500:
                if num >= 900:
                    output += "CM"
                    num -= 900
                else:
                    output += "D"
                    num -= 500
            else:
                if num >= 100:
                    if num >= 400:
                        output += "CD"
                        num -= 400
                    else:
                        output += "C"
                        num -= 100
                else:
                    if num >= 50:
                        if num >= 90:
                            output += "XC"
                            num -= 90
                        else:
                            output += "L"
                            num -= 50
                    else:
                        if num >= 10:
                            if num >= 40:
                                output += "XL"
                                num -= 40
                            else:
                                output += "X"
                                num -= 10
                        else:
                            if num >= 5:
                                if num == 9:
                                    output += "IX"
                                    num -= 9
                                    break
                                else:
                                    output += "V"
                                    num -= 5
                            else:
                                if num == 4:
                                    output += "IV"
                                    num -= 4
                                    break
                                else:
                                    output += ("I" * num)
                                    break

    return output

num = 2999
print(intToRoman(num))


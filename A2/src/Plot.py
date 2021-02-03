## @file
#  @author
#  @brief
#  @date
#  @details

import matplotlib

def plot(w, t):
    if len(w) != len(t):
        raise ValueError
    xvalues, yvalues = w[0], w[1]
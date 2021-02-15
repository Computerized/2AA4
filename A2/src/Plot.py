## @file
#  @author
#  @brief
#  @date
#  @details

import matplotlib.pyplot as plt

def plot(w,t):
    x = []
    y = []
    for item in w:
        x.append(item[0])
        y.append(item[1])
    plt.figure("Motion Simulation")
    plt.subplot(311)
    plt.xlabel("x(t)")
    plt.ylabel("t")
    plt.plot(x,t)
    plt.subplot(312)
    plt.xlabel("y(t)")
    plt.ylabel("t")
    plt.plot(y,t)
    plt.subplot(313)
    plt.xlabel("x(t)")
    plt.ylabel("y(t)")
    plt.plot(x, y)

    plt.subplots_adjust(left=0.125, bottom=0.1, right=0.9, top=0.9, wspace=0.2, hspace=0.8)

    plt.show()
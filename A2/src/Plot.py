## @file Plot.py
#  @author Alan Scott
#  @brief Function for generating matplot plots
#  @date 16/02/21
#  @details This file contains a single function which plots a series of x, y, and y
#           relations on 3 graphs on 1 window.

import matplotlib.pyplot as plt


## @brief Plot function
#  @details This function plots 3 different graphs of x vs t, y vs t and x vs y. It does so
#           on 1 window using 3 vertically oriented subplots.
#  @param w 2D array containing pairs of x and y coordinates
#  @param t Array contain all the values of t
def plot(w, t):
    x = []
    y = []
    for item in w:
        x.append(item[0])
        y.append(item[1])
    plt.figure("Motion Simulation")
    plt.subplot(311)
    plt.xlabel("x(t)")
    plt.ylabel("t")
    plt.plot(t, x)
    plt.subplot(312)
    plt.xlabel("y(t)")
    plt.ylabel("t")
    plt.plot(t, y)
    plt.subplot(313)
    plt.xlabel("x(t)")
    plt.ylabel("y(t)")
    plt.plot(x, y)

    plt.subplots_adjust(left=0.125, bottom=0.1, right=0.9, top=0.9, wspace=0.2, hspace=0.8)

    plt.show()

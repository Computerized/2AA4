## @file Scene.py
#  @author Samia Anwar
#  @brief Generic module to represent forces and velocity on an object
#  @date Feb 2, 2021
#  @details Simulates motion of an object based on force and initial velocity

from Shape import Shape
from scipy.integrate import odeint

## @brief This module takes in a Shape object and generates seqeuences of numbers to simulate
#  its motion given a force acting upon it and its initial velocity


class Scene(Shape):
    ## @brief constructor for class Scene, represents the motion acted upon a given shape
    #  @param ds is a Shape object defined elsewhere in the code and contains x-y coordinates
    #  for center of mass, a total mass and a moment of inertia
    #  @param dfx is the formula for the x-direction force acted upon the object
    #  @param dfy is the formula for the y-direction force acted upon the object
    #  @param dvx is a real number representation of the starting velocity of the object
    #  in the x-plane
    #  @param dvy is a real number representation of the starting velocity of the object
    #  in the y-plane
    #  @details the units of these real number representations is at the discretion
    #  of the user and is no way controlled or represented in this python implementation
    def __init__(self, ds, dfx, dfy, dvx, dvy):
        self.s = ds
        self.fx = dfx
        self.fy = dfy
        self.vx = dvx
        self.vy = dvy

    ## @brief Returns the shape object associated with the Scene
    #  @return shape object and all of its parametres
    def get_shape(self):
        return self.s

    ## @brief returns the force equations in the x and y direction
    #  @return x and y direction force equations as python functions
    def get_unbal_forces(self):
        return self.fx, self.fy

    ## @brief returns the x and y direction values of velocity
    #  @return x and y direction real number values of velocity
    def get_init_velo(self):
        return self.vx, self.vy

    ## @brief changes the shape specified in the Scene
    #  @param s_new is an Shape object containing the specified parameters
    def set_shape(self, s_new):
        self.s = s_new

    ## @brief changes the x and y direction force functions specified in the Scene
    #  @param fx_n is a python function representing the new x-direction force function
    #  @param fy_n is a python function representing the new y-direction force function
    def set_unbal_forces(self, fx_n, fy_n):
        self.fx = fx_n
        self.fy = fy_n

    ## @brief changes the x and y direction initial velocities specified in the Scene
    #  @param vx_n is a real number velocity values representing the new x-direction velocity
    #  @param vy_n is a real number velocity values representing the new y-direction velocity
    def set_init_velo(self, vx_n, vy_n):
        self.vx = vx_n
        self.vy = vy_n

    ## @brief Integrates the given functions based on initial velocity and a step value
    #  @param tf is a real number used in the numerator of the calculations
    #  @param nsteps is a natural number used in the denominator of the calculations
    #  @assumption assume that nsteps is never equal to one
    #  @return two sequences of real numbers
    def sim(self, tf, nsteps):
        t = []
        for i in range(nsteps):
            t.append((i * tf) / (nsteps - 1))
        return t, odeint(self.__ode__, [self.s.cm_x(), self.s.cm_y(), self.vx, self.vy], t)

    ## @brief Generates an array for computation in odeint method in sim()
    #  @param w is a sequence with 4 values
    #  @param t is a real number used as an input for the given force equations
    #  @return an array with 4 elements inside
    def __ode__(self, w, t):
        return [w[2], w[3], self.fx(t) / self.s.mass(), self.fy(t) / self.s.mass()]

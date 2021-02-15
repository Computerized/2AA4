## @file Scene.py
#  @author Alan Scott
#  @brief
#  @date
#  @details

from Shape import Shape
from scipy import integrate as ODE


class Scene(Shape):

    def __init__(self, sprime, fxprime, fyprime, vxprime, vyprime):
        self.s, self.fx, self.fy, self.vx, self.vy = sprime, fxprime, fyprime, vxprime, vyprime

    def get_shape(self):
        return self.s

    def get_unbal_forces(self):
        return self.fx, self.fy

    def get_init_velocity(self):
        return self.vx, self.vy

    def set_shapes(self, sprime):
        self.s = sprime

    def set_unbal_forces(self, fxprime, fyprime):
        self.fx, self.fy = fxprime, fyprime

    def set_init_velo(self, vxprime, vyprime):
        self.vx, self.vy = vxprime, vyprime

    def sim(self, tfinal, nsteps):
        t = []
        for i in range(nsteps):
            t.append((i * tfinal)/(nsteps-1))
        out = ODE.odeint(self.__ode__(),[self.s.cm_x(), self.s.cm_y(), self.vx, self.vy], t)
        return t, out

    def __ode__(self, w, t):
        return [w[2], w[3], self.fx/self.s.mass, self.fy/self.s.mass]



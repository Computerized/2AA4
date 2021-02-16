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

        total = 0
    g = 9.81  # accel due to gravity (m/s^2)
    m = 1  # mass (kg)

    def Fx(self,t):
        return 5 if t < 5 else 0


    def Fy(self,t):
        return -self.g * self.m if t < 3 else self.g * self.m

    def cm_x(self):
        pass

    def cm_y(self):
        pass

    def mass(self):
        pass

    def m_inert(self):
        pass

    def get_shape(self):
        return self.s

    def get_unbal_forces(self):
        return self.fx, self.fy

    def get_init_velo(self):
        return self.vx, self.vy

    def set_shape(self, sprime):
        self.s = sprime

    def set_unbal_forces(self, fxprime, fyprime):
        self.fx, self.fy = fxprime, fyprime

    def set_init_velo(self, vxprime, vyprime):
        self.vx, self.vy = vxprime, vyprime

    def sim(self, tfinal, nsteps):
        t = []
        for i in range(nsteps):
            t.append((i * tfinal)/(nsteps-1))
        out = ODE.odeint(self.ode,[self.s.cm_x(), self.s.cm_y(), self.vx, self.vy], t)
        return t, out

    def ode(self, w, t):
        return [w[2], w[3], self.Fx(t)/self.s.mass(), self.Fy(t)/self.s.mass()]



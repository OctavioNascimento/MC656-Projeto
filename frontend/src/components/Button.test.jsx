import { render, screen } from '@testing-library/react'
import Button from "./Button"

test('Should render a button with text "LOGIN"', () => {
     render(<Button value="LOGIN"/>)
     expect(screen.getByText('LOGIN')).toBeInTheDocument()
})
